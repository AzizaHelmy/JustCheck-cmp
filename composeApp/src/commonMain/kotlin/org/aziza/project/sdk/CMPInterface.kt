package org.aziza.project.sdk

interface HomeScreenEventListener {
    fun onRedirectToScreenClicked(screenId: String)
    fun onRetry()
}
