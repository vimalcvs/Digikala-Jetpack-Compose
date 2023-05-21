package com.vimalcvs.digikalacompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vimalcvs.digikalacompose.navigation.BottomNavigationBar
import com.vimalcvs.digikalacompose.navigation.SetupNavGraph
import com.vimalcvs.digikalacompose.ui.components.AppConfig
import com.vimalcvs.digikalacompose.ui.components.ChangeStatusBarColor
import com.vimalcvs.digikalacompose.ui.theme.DigikalaComposeTheme
import com.vimalcvs.digikalacompose.util.Constants.ENGLISH_LANG
import com.vimalcvs.digikalacompose.util.Constants.USER_LANGUAGE
import com.vimalcvs.digikalacompose.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaComposeTheme {
                navController = rememberNavController()
                ChangeStatusBarColor(navController = navController)

                AppConfig()

                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)

                val direction = if (USER_LANGUAGE == ENGLISH_LANG) {
                    LayoutDirection.Ltr
                } else {
                    LayoutDirection.Rtl
                }

                CompositionLocalProvider(LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController, onItemClick = {
                                navController.navigate(it.route)
                            })
                        }
                    ) {
                        SetupNavGraph(navController = navController)
                    }

                }

            }
        }
    }
}

