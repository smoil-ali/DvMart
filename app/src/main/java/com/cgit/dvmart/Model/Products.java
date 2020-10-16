package com.cgit.dvmart.Model;


import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {
    private int id;

    private String name;

    private String slug;

    private String permalink;

    private String date_created;

    private String date_created_gmt;

    private String date_modified;

    private String date_modified_gmt;

    private String type;

    private String status;

    private boolean featured;

    private String catalog_visibility;

    private String description;

    private String short_description;

    private String sku;

    private String price;

    private String regular_price;

    private String sale_price;

    private String date_on_sale_from;

    private String date_on_sale_from_gmt;

    private String date_on_sale_to;

    private String date_on_sale_to_gmt;

    private String price_html;

    private boolean on_sale;

    private boolean purchasable;

    private int total_sales;

    private boolean virtual;

    private boolean downloadable;

    private List<String> downloads;

    private int download_limit;

    private int download_expiry;

    private String external_url;

    private String button_text;

    private String tax_status;

    private String tax_class;

    private boolean manage_stock;

    private String stock_quantity;

    private String stock_status;

    private String backorders;

    private boolean backorders_allowed;

    private boolean backordered;

    private boolean sold_individually;

    private String weight;

    private Dimensions dimensions;

    private boolean shipping_required;

    private boolean shipping_taxable;

    private String shipping_class;

    private int shipping_class_id;

    private boolean reviews_allowed;

    private String average_rating;

    private int rating_count;

    private List<Integer> related_ids;

    private List<String> upsell_ids;

    private List<String> cross_sell_ids;

    private int parent_id;

    private String purchase_note;

    private List<prod_Cat> categories;

    private List<Tags> tags;

    private List<Image> images;

    private List<String> attributes;

    private List<String> default_attributes;

    private List<String> variations;

    private List<String> grouped_products;

    private int menu_order;

    private List<Meta_data> meta_data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_created_gmt() {
        return date_created_gmt;
    }

    public void setDate_created_gmt(String date_created_gmt) {
        this.date_created_gmt = date_created_gmt;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public String getDate_modified_gmt() {
        return date_modified_gmt;
    }

    public void setDate_modified_gmt(String date_modified_gmt) {
        this.date_modified_gmt = date_modified_gmt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getDate_on_sale_from() {
        return date_on_sale_from;
    }

    public void setDate_on_sale_from(String date_on_sale_from) {
        this.date_on_sale_from = date_on_sale_from;
    }

    public String getDate_on_sale_from_gmt() {
        return date_on_sale_from_gmt;
    }

    public void setDate_on_sale_from_gmt(String date_on_sale_from_gmt) {
        this.date_on_sale_from_gmt = date_on_sale_from_gmt;
    }

    public String getDate_on_sale_to() {
        return date_on_sale_to;
    }

    public void setDate_on_sale_to(String date_on_sale_to) {
        this.date_on_sale_to = date_on_sale_to;
    }

    public String getDate_on_sale_to_gmt() {
        return date_on_sale_to_gmt;
    }

    public void setDate_on_sale_to_gmt(String date_on_sale_to_gmt) {
        this.date_on_sale_to_gmt = date_on_sale_to_gmt;
    }

    public String getPrice_html() {
        return price_html;
    }

    public void setPrice_html(String price_html) {
        this.price_html = price_html;
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public int getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public List<String> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<String> downloads) {
        this.downloads = downloads;
    }

    public int getDownload_limit() {
        return download_limit;
    }

    public void setDownload_limit(int download_limit) {
        this.download_limit = download_limit;
    }

    public int getDownload_expiry() {
        return download_expiry;
    }

    public void setDownload_expiry(int download_expiry) {
        this.download_expiry = download_expiry;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public String getTax_status() {
        return tax_status;
    }

    public void setTax_status(String tax_status) {
        this.tax_status = tax_status;
    }

    public String getTax_class() {
        return tax_class;
    }

    public void setTax_class(String tax_class) {
        this.tax_class = tax_class;
    }

    public boolean isManage_stock() {
        return manage_stock;
    }

    public void setManage_stock(boolean manage_stock) {
        this.manage_stock = manage_stock;
    }

    public String getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(String stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public String getBackorders() {
        return backorders;
    }

    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    public boolean isBackorders_allowed() {
        return backorders_allowed;
    }

    public void setBackorders_allowed(boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public boolean isBackordered() {
        return backordered;
    }

    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public boolean isSold_individually() {
        return sold_individually;
    }

    public void setSold_individually(boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isShipping_required() {
        return shipping_required;
    }

    public void setShipping_required(boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public boolean isShipping_taxable() {
        return shipping_taxable;
    }

    public void setShipping_taxable(boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public int getShipping_class_id() {
        return shipping_class_id;
    }

    public void setShipping_class_id(int shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public boolean isReviews_allowed() {
        return reviews_allowed;
    }

    public void setReviews_allowed(boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public List<Integer> getRelated_ids() {
        return related_ids;
    }

    public void setRelated_ids(List<Integer> related_ids) {
        this.related_ids = related_ids;
    }

    public List<String> getUpsell_ids() {
        return upsell_ids;
    }

    public void setUpsell_ids(List<String> upsell_ids) {
        this.upsell_ids = upsell_ids;
    }

    public List<String> getCross_sell_ids() {
        return cross_sell_ids;
    }

    public void setCross_sell_ids(List<String> cross_sell_ids) {
        this.cross_sell_ids = cross_sell_ids;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getPurchase_note() {
        return purchase_note;
    }

    public void setPurchase_note(String purchase_note) {
        this.purchase_note = purchase_note;
    }

    public List<prod_Cat> getCategories() {
        return categories;
    }

    public void setCategories(List<prod_Cat> categories) {
        this.categories = categories;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<String> getDefault_attributes() {
        return default_attributes;
    }

    public void setDefault_attributes(List<String> default_attributes) {
        this.default_attributes = default_attributes;
    }

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

    public List<String> getGrouped_products() {
        return grouped_products;
    }

    public void setGrouped_products(List<String> grouped_products) {
        this.grouped_products = grouped_products;
    }

    public int getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(int menu_order) {
        this.menu_order = menu_order;
    }

    public List<Meta_data> getMeta_data() {
        return meta_data;
    }

    public void setMeta_data(List<Meta_data> meta_data) {
        this.meta_data = meta_data;
    }
}
