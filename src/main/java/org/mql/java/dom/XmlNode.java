package org.mql.java.dom;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jakarta.servlet.ServletContext;
public class XmlNode {
private Node node;
	
	
	public XmlNode(ServletContext context) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		//DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//creer dynmaiqument 
		//FactorBean->Factory Method 
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(context.getResourceAsStream("/WEB-INF/routes/routes.xml"));
			node = document.getFirstChild();
			while(node.getNodeType() != Node.ELEMENT_NODE) {
				System.out.println(node.getNodeValue());
				node = node.getNextSibling();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur : "+e.getMessage());
		}
	}
	
	public XmlNode(Node node) {
		this.node = node;
	}
	
	public XmlNode[] children() {
		Vector<XmlNode> nodes = new Vector<XmlNode>();
		NodeList list = node.getChildNodes();
		for(int i = 0;i<list.getLength();i++) {
			if(list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				nodes.add(new XmlNode(list.item(i)));
			}
		
		}
		return nodes.toArray(new XmlNode[nodes.size()]);
	}
	
	public XmlNode child(String name) {
		NodeList list = node.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeName().equals(name))
				return new XmlNode(list.item(i));
		}
		return null;
	}
	
	public String value() {
		if (node.getNodeType() == Node.ELEMENT_NODE)
			return node.getFirstChild().getNodeValue();
		return node.getNodeValue();
	}

	public void setValue(String value) {
		node.setTextContent(value);
	}
	
	public String name() {
		return node.getNodeName();
	}
	
	public boolean isElemnt() {
		return (node.getNodeType() == Node.ELEMENT_NODE);
	}
	
	public String attribute(String name) {
		//get Attribute
		NamedNodeMap atts =  node.getAttributes();
		return atts.getNamedItem(name).getNodeValue();
	}
	public int intAttribute(String name) {
		NamedNodeMap atts = node.getAttributes();
		try {
			return Integer.parseInt(atts.getNamedItem(name).getNodeValue());
		} catch (Exception e) {
			return -1;
		}
	}
	
	public String getvalue() {
		if(node.getNodeType() == Node.ELEMENT_NODE)
			return node.getFirstChild().getNodeValue();
		return node.getNodeValue();
	}
	
	public String strAttribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		try {
			return attributes.getNamedItem(name).getNodeValue();
		} catch (Exception e) {
			System.out.println("INFO : Looking for Attribute : "+ name +" -> "+ e.getMessage());
			return null;
		}
	}
	

	
	private void print(Node node) {
		System.out.println(node.getNodeName()+" , "+node.getNodeType()+", "+
				node.getNodeValue());
		
	}

}
