
package net.codetojoy.homer

class Config {
    def jQueryPath 
    def jQueryUiPath 
    def jQueryUiCssPath 
        
    public Config(def configFile) {
        Properties properties = new Properties()
        properties.load(new FileInputStream(configFile))
        this.jQueryPath = properties.getProperty("jquery.path")
        this.jQueryUiPath = properties.getProperty("jquery.ui.path")
        this.jQueryUiCssPath = properties.getProperty("jquery.ui.css.path")
    }
}