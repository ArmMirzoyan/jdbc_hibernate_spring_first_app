package com.example.tomcattest.servise.dto;

import com.example.tomcattest.model.Configuration;
import com.example.tomcattest.servise.ItemDetailsDTO;

import javax.validation.constraints.*;
import java.util.Objects;

public class ItemDTO {

    private Long id;
    @NotBlank(message = "name must not be blank")
    private String name;
    @PositiveOrZero
    @Min(value = 10)
    @Max(value = 1000)
    private Integer basePrice;
    @NotNull
    private ItemDetailsDTO itemDetails;
    private String groupName;
    private String currency;
    private String image_url;
    private Configuration configuration;
    private GroupDTO parentDTO;
    private int parentGroup;

    public ItemDTO() {
    }

    public ItemDTO(String name, Integer basePrice, String image_url, String currency) {
        this.name = name;
        this.image_url = image_url;
        this.basePrice = basePrice;
        this.currency = currency;
    }

    public ItemDTO(String name, Integer basePrice, String image_url) {
        this.name = name;
        this.basePrice = basePrice;
        this.image_url = image_url;
    }

    public ItemDTO(String name, Integer basePrice, String image_url, String currency, Configuration configuration) {
        this.name = name;
        this.basePrice = basePrice;
        this.image_url = image_url;
        this.currency = currency;
        this.configuration = configuration;
    }

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

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public ItemDetailsDTO getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ItemDetailsDTO itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(int parentGroup) {
        this.parentGroup = parentGroup;
    }

    public GroupDTO getParentDTO() {
        return parentDTO;
    }

    public void setParentDTO(GroupDTO parentDTO) {
        this.parentDTO = parentDTO;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
