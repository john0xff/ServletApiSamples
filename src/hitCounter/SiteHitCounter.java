package hitCounter;

// Import required java libraries
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * @WebFilter console output 
 */
@WebFilter(filterName = "/14.Servlets-Hits_Counter/SiteHitCounter", urlPatterns = {"/*"})
public class SiteHitCounter implements Filter
{

	private int hitCount;

	public void init(FilterConfig config) throws ServletException
	{
		// Reset hit counter.
		hitCount = 0;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException
	{
		// increase counter by one
		hitCount++;

		// Print the counter.
		System.out.println("Site visits count :" + hitCount);

		// Pass request back down the filter chain
		chain.doFilter(request, response);
	}

	public void destroy()
	{
		// This is optional step but if you like you
		// can write hitCount value in your database.
	}
}