package com.albertomagalhaes.doggos.commons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.albertomagalhaes.doggos.R
import java.lang.reflect.ParameterizedType

open class BaseFragment<Binding: ViewBinding>(
    private val bottomNavVisible: Boolean = true
): Fragment() {

    lateinit var binding: Binding
    lateinit var appActivity: AppActivity

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bindingClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<Binding>
        val method = bindingClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        binding = method.invoke(null, layoutInflater, container, false) as Binding
        appActivity = activity as AppActivity
        appActivity.setBottomNavigationVisible(bottomNavVisible)
        appActivity.setToolbarTitle(getString(R.string.app_name))
        appActivity.setToolbarNavigationButton(false)
        return binding.root
    }

}