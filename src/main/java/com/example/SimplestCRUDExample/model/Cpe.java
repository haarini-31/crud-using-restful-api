package com.example.SimplestCRUDExample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cpe")
public class Cpe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpe_title")
    private String cpeTitle;

    @Column(name = "cpe_22_uri")
    private String cpe22Uri;

    @Column(name = "reference_links", length = 2000)
    private String referenceLinks;

    @Column(name = "cpe_deprecation_date")
    private String cpeDeprecationDate;

    public Cpe() {}

    public Long getId() { return id; }

    public String getCpeTitle() { return cpeTitle; }
    public void setCpeTitle(String cpeTitle) { this.cpeTitle = cpeTitle; }

    public String getCpe22Uri() { return cpe22Uri; }
    public void setCpe22Uri(String cpe22Uri) { this.cpe22Uri = cpe22Uri; }

    public String getReferenceLinks() { return referenceLinks; }
    public void setReferenceLinks(String referenceLinks) { this.referenceLinks = referenceLinks; }

    public String getCpeDeprecationDate() { return cpeDeprecationDate; }
    public void setCpeDeprecationDate(String cpeDeprecationDate) { this.cpeDeprecationDate = cpeDeprecationDate; }
}