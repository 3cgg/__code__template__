package test.me.libme.webseed.autogenerator.demo.model;

import me.libme.webseed.fn._template.ftl.java.InfoColumn;
import me.libme.webseed.fn._template.ftl.java.InfoTable;

import java.util.Date;

@InfoTable("t_car")
public class Car {

    @InfoColumn("_name")
    private String name;

    @InfoColumn(value = "color",lable = "颜色")
    private String color;

    @InfoColumn(value = "log",lable = "品牌")
    private String log;

    @InfoColumn(value = "weight",lable = "重量",jdbcType = "DOUBLE")
    private double weight;

    @InfoColumn(value = "produce_time",lable = "生产日期",jdbcType = "DATE")
    private Date produceTime;

    /**
     * the primary key , uuid
     */
    private String id;

    /**
     * create user id
     */
    private String createId;

    /**
     * update user id
     */
    private String updateId;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * marks whether the record is deleted. Value is Y|N
     */
    private String deleted;

    /**
     * the property can limit the async operation effectively
     */
    private int version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
