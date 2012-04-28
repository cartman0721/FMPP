

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 数据模型基类，重写“toString”、“equals”和“hashCode”方法。
 * 
 * @author jianjie.wangjj
 * @see org.apache.commons.lang.builder.ToStringBuilder
 * @see org.apache.commons.lang.builder.EqualsBuilder
 * @see org.apache.commons.lang.builder.HashCodeBuilder
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Long              id;
    /**
     * 创建人
     */
    private String            gmtCreator;
    /**
     * 创建时间
     */
    private Date              gmtCreated;
    /**
     * 修改人
     */
    private String            gmtModifier;
    /**
     * 修改时间
     */
    private Date              gmtModified;

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getGmtCreator() {
        return gmtCreator;
    }

    public void setGmtCreator(String gmtCreator) {
        this.gmtCreator = gmtCreator;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtModifier() {
        return gmtModifier;
    }

    public void setGmtModifier(String gmtModifier) {
        this.gmtModifier = gmtModifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
