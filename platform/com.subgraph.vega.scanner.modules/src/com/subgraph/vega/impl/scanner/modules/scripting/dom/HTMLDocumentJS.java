package com.subgraph.vega.impl.scanner.modules.scripting.dom;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.w3c.dom.html2.HTMLDocument;
import org.w3c.dom.html2.HTMLElement;

public class HTMLDocumentJS extends DocumentJS {

	private static final long serialVersionUID = 1L;

	private HTMLDocument htmlDocument;
	
	public HTMLDocumentJS() {
		htmlDocument = null;
	}
	
	public HTMLDocumentJS(HTMLDocument document) {
		super(document);
		this.htmlDocument = document;
	}
	
	@Override
	public void jsConstructor(Object ob) {
		final HTMLDocument d = (HTMLDocument) Context.jsToJava(ob, HTMLDocument.class);
		this.htmlDocument = d;
		this.document = d;
		setNode(d);
	}
	
	@Override
	public String getClassName() {
		return "HTMLDocument";
	}
	
	public Scriptable jsGet_anchors() {
		HTMLCollectionJS collection = new HTMLCollectionJS(htmlDocument.getAnchors(), ScriptableObject.getTopLevelScope(this));
		exportObject(collection);
		return collection;
	}
	
	public Scriptable jsGet_applets() {
		HTMLCollectionJS collection = new HTMLCollectionJS(htmlDocument.getApplets(), ScriptableObject.getTopLevelScope(this));
		exportObject(collection);
		return collection;
	}
	
	public Scriptable jsGet_body() {
		HTMLElement element = htmlDocument.getBody();
		if(element == null)
			return null;
		HTMLElementJS jselement = new HTMLElementJS(element);
		exportObject(jselement);
		return jselement;
	}
	
	public String jsGet_cookie() {
		return htmlDocument.getCookie();
	}
	
	public String jsGet_domain() {
		return htmlDocument.getDomain();
	}
	
	public Scriptable jsGet_forms() {
		HTMLCollectionJS collection = new HTMLCollectionJS(htmlDocument.getForms(), ScriptableObject.getTopLevelScope(this));
		exportObject(collection);
		return collection;
	}
	
	public Scriptable jsGet_images() {
		HTMLCollectionJS collection = new HTMLCollectionJS(htmlDocument.getImages(), ScriptableObject.getTopLevelScope(this));
		exportObject(collection);
		return collection;
	}
	
	public Scriptable jsGet_links() {
		HTMLCollectionJS collection = new HTMLCollectionJS(htmlDocument.getLinks(), ScriptableObject.getTopLevelScope(this));
		exportObject(collection);
		return collection;
	}
	
	public String jsGet_referrer() {
		return htmlDocument.getReferrer();
	}
	
	public String jsGet_title() {
		return htmlDocument.getTitle();
	}
	
	public String jsGet_URL() {
		return htmlDocument.getURL();
	}
	
	public void jsFunction_close() {
		htmlDocument.close();
	}
	
	public Scriptable jsFunction_getElementsByName(String elementName) {
		final NodeListJS nodeList = new NodeListJS(htmlDocument.getElementsByName(elementName), ScriptableObject.getTopLevelScope(this));
		exportObject(nodeList);
		return nodeList;
	}
	
	public void jsFunction_open() {
		htmlDocument.open();
	}
	
	public void jsFunction_write(String text) {
		htmlDocument.write(text);
	}
	
	public void jsFunction_writeln(String text) {
		htmlDocument.writeln(text);
	}
}
