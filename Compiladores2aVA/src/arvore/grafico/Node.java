package arvore.grafico;

public class Node {
String key,parent,name;

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public String getParent() {
	return parent;
}

public void setParent(String parent) {
	this.parent = parent;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String toJsonString(){
	return "{ key: \""+key+"\", parent: \""+parent+"\", name: \""+name+"\"}";
}
}
