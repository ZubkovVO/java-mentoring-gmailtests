package com.epam.mentoring.pages;

import com.epam.mentoring.utils.Browser;

abstract class AbstractPage {
    protected Browser browser;

    protected AbstractPage() {this.browser = Browser.getInstance();}
}
