
package net.codetojoy.homer

class Template {    
    private final String HOMER_JQUERY = "HOMER_JQUERY"
    private final String HOMER_JQUERY_UI = "HOMER_JQUERY_UI"
    private final String HOMER_JQUERY_UI_CSS = "HOMER_JQUERY_UI_CSS"
    private final String HOMER_BODY = "HOMER_BODY"
    
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
        def buffer = new StringBuilder()
        
        linksList.each { links ->
            def header = links.header
            buffer.append("<h3><a href='#'>${header}</a></h3>" + "\n")
            buffer.append("<div>" + "\n")
            
            links.links.each { link ->
                def href = link.href
                def name = link.name
                buffer.append("<a class='link' href='${href}'>${name}</a> <br/>" + "\n")
            }
            
            buffer.append("</div>" + "\n")
        }
        
        return buffer.toString()
    }
}
