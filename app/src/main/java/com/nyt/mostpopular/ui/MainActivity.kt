package com.nyt.mostpopular.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nyt.mostpopular.NYTApplication
import com.nyt.mostpopular.R
import com.nyt.mostpopular.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setupWithNavController(getNavController())

        getNavController().addOnDestinationChangedListener { _, des, _ ->

            when (des.id) {
                R.id.mostViewedFragment ->
                    supportActionBar?.title = getString(R.string.app_name)
            }
        }
    }

    private fun getNavController(): NavController {

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun getAppLanguage(context: Context): String {
        return (context.applicationContext as NYTApplication).getAppLanguage()
    }

    override fun onBackPressed() {
        if (getNavController().currentDestination?.id != R.id.mostViewedFragment)
            super.onBackPressed()
        else finishAfterTransition()
    }
}
