package com.hengyunsoft.validator;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;

public class Resource {
    /**
     * 主键
     *
     * @mbggenerated
     */
	@NotNull(groups=MustNoneNull.class,message="{resource.id}{javax.validation.constraints.NotNull.message}")
    private Long id;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
	@Length(max=3)
    private String name;
    
    /**
     * 是否公有资源，就是无需分配就可以访问的。所有人可见
     */
	@NotNull(groups=MustNoneNull.class)
	@Length(max=3)
    private Boolean publicIs;

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Boolean getPublicIs() {
		return publicIs;
	}



	public void setPublicIs(Boolean publicIs) {
		this.publicIs = publicIs;
	}

	public Resource(Long id, String name, Boolean publicIs) {
		this.id = id;
		this.name = name;
		this.publicIs = publicIs;
	}
	
}