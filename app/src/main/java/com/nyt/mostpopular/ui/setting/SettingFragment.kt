package com.nyt.mostpopular.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.switchmaterial.SwitchMaterial
import com.nyt.mostpopular.R
import com.nyt.mostpopular.ui.base.BaseFragment
import com.nyt.mostpopular.utils.LanguageUtils
import com.nyt.mostpopular.utils.LocaleManager
import com.nyt.mostpopular.utils.ThemeUtils

/**
 * Created by Muhammad Maqsood on 01/08/2021.
 */
class SettingFragment : BaseFragment() {

    private val settingViewModel by viewModels<SettingViewModel>()

    private var btnThemeToggler: SwitchMaterial? = null
    private var btnRtlToggle: SwitchMaterial? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initViews(view)

        btnThemeToggler?.isChecked = ThemeUtils.getIsDarkTheme(requireActivity())
        btnRtlToggle?.isChecked = LanguageUtils.isRTL(settingViewModel.getAppLanguage())

        btnThemeToggler?.setOnCheckedChangeListener { _, isChecked ->

            if (!ThemeUtils.getIsDarkTheme(requireActivity()) && isChecked) {
                settingViewModel.setIsDarkMode(true)
                ThemeUtils.enableDarkTheme()
            } else if (ThemeUtils.getIsDarkTheme(requireActivity()) && !isChecked) {
                settingViewModel.setIsDarkMode(false)
                ThemeUtils.enableLightTheme()
            }
        }

        btnRtlToggle?.setOnCheckedChangeListener { _, isChecked ->

            if (!LanguageUtils.isRTL(settingViewModel.getAppLanguage()) && isChecked) {
                // Change to arabic
                settingViewModel.toggleLanguage()
                LocaleManager.restart(requireActivity())
            } else if (LanguageUtils.isRTL(settingViewModel.getAppLanguage()) && !isChecked) {
                // Change to english
                settingViewModel.toggleLanguage()
                LocaleManager.restart(requireActivity())
            }
        }
    }

    private fun initViews(view: View) {
        btnThemeToggler = view.findViewById(R.id.btn_themeToggler)
        btnRtlToggle = view.findViewById(R.id.btn_rtlToggle)
    }
}
