package com.xmsmartcity.pojo;

public class TsRoleFunction {
    private String id;

    private String operation;

    private String functionid;

    private String roleid;

    private String datarule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getFunctionid() {
        return functionid;
    }

    public void setFunctionid(String functionid) {
        this.functionid = functionid == null ? null : functionid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getDatarule() {
        return datarule;
    }

    public void setDatarule(String datarule) {
        this.datarule = datarule == null ? null : datarule.trim();
    }
}