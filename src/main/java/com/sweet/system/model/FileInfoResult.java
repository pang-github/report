package com.sweet.system.model;import lombok.Data;import lombok.experimental.Accessors;@Data@Accessors(chain = true)public class FileInfoResult {    private String id;    private String name;    private String updateTime;    private String type;    private boolean isDir;    private String url;    private String smUrl;}