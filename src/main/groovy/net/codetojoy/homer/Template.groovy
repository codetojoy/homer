
package net.codetojoy.homer

class Template {    
    private final String HOMER_JQUERY = "HOMER_JQUERY"
    private final String HOMER_JQUERY_UI = "HOMER_JQUERY_UI"
    private final String HOMER_JQUERY_UI_CSS = "HOMER_JQUERY_UI_CSS"
    private final String HOMER_BODY = "HOMER_BODY"

    private final String BUTTON_BODY = "button"

    def bodyBuilder 
   
    Template(def bodyStyle) {
        def bodyBuilder = new AccordionBody()
 
        if (BUTTON_BODY.equalsIgnoreCase(bodyStyle)) {
            bodyBuilder = new ButtonBody()
        } 

        this.bodyBuilder = bodyBuilder
    }
 
    public String stamp(Model model) {
        String text = new File(model.templateFile).getText()
        
        text = text.replace(HOMER_JQUERY_UI_CSS, model.jQueryUiCssPath)
        text = text.replace(HOMER_JQUERY_UI, model.jQueryUiPath)
        text = text.replace(HOMER_JQUERY, model.jQueryPath)
        
        def body = buildBody(model.linksList)
        text = text.replace(HOMER_BODY, body)
        
        return text
    }
    
    String buildBody(def linksList) {
        return bodyBuilder.build(linksList)
    }
}
