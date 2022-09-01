package epam.zhivotov.new_tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class NewTag extends SimpleTagSupport{
	
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		 Calendar cal = new GregorianCalendar();
		    out.println(new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH).format(cal.getTime()));
	}

}
