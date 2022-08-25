package cn.itcast.itcast.itcaststore.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //处理请求乱码
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletRequest myRequest = (HttpServletRequest) new MyRequest(httpServletRequest);
        //处理响应乱码
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(myRequest, response);
    }

    public void destroy() {

    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}

//自定义request对象
class MyRequest extends HttpServletRequestWrapper {
    private final HttpServletRequest request;
    private boolean hasEncode;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        //先获得请求方式
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            //post 请求
            try {
                request.setCharacterEncoding("utf-8");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (method.equalsIgnoreCase("get")) {
            //get请求
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (!hasEncode) {
                //确保get 手动编码逻辑只运行一次
                for (String parameterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(parameterName);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            try {
                                values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;

            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        return parameterMap.get(name);
    }
}
