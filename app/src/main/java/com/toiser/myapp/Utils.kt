package com.toiser.myapp

import androidx.appcompat.app.ActionBar


fun hideActionBar(supportActionBar : ActionBar?) {
    if(supportActionBar != null) {
        supportActionBar?.hide()
    }
}

