package com.JavaBean.test;

import java.util.HashMap;
import java.util.Map;

public class RegisterFormBean {
    private String name;
    private String password;
    private String password2;
    private String email;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validate() {
        boolean flag = true;
        if (name == null || name.trim().equals("")) {
            errors.put("name", "please insert name");
            flag = false;
        }
        if (password == null || password.trim().equals("")) {
            errors.put("password", "please insert password");
            flag = false;
        } else if (password.length() > 12 || password.length() < 5) {
            errors.put("password", "insert 6-12 char");
            flag = false;
        }
        if (email == null || email.trim().equals("")) {
            errors.put("email", "please insert email");
            flag = false;
        } else if (!email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+")) {
            errors.put("email", "email format error");
            flag = false;
        }
        return flag;
    }

    //向Map集合errors中添加错误信息
    public void setErrorMsg(String err, String errMsg) {
        if ((err != null) && (errMsg != null)) {
            errors.put(err, errMsg);
        }
    }

    //获取errors集合
    public Map<String, String> getErrors() {
        return errors;
    }

}
