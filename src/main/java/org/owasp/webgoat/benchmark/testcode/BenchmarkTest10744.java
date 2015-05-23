/**
* OWASP WebGoat Benchmark Edition (WBE) v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* WebGoat Benchmark Edition (WBE) project. For details, please see
* <a href="https://www.owasp.org/index.php/WBE">https://www.owasp.org/index.php/WBE</a>.
*
* The WBE is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The WBE is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10744")
public class BenchmarkTest10744 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = new Test().doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
            throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a28494 = param; //assign
		StringBuilder b28494 = new StringBuilder(a28494);  // stick in stringbuilder
		b28494.append(" SafeStuff"); // append some safe content
		b28494.replace(b28494.length()-"Chars".length(),b28494.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map28494 = new java.util.HashMap<String,Object>();
		map28494.put("key28494", b28494.toString()); // put in a collection
		String c28494 = (String)map28494.get("key28494"); // get it back out
		String d28494 = c28494.substring(0,c28494.length()-1); // extract most of it
		String e28494 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d28494.getBytes() ) )); // B64 encode and decode it
		String f28494 = e28494.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g28494 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g28494); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass