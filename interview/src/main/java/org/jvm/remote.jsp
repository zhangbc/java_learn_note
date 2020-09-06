<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.jvm.*" %>
<%
    InputStream is=new FileInputStream("/home/projects/java_pro/java_projects/interview/target/classes/org/jvm/RemoteTest.class");
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();

    out.println("<textarea style='width:1000;height=800'>");
    out.println(JavaClassExecutor.execute(b));
    out.println("</textarea>");
%>