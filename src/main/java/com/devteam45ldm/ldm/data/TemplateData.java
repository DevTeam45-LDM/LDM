package com.devteam45ldm.ldm.data;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TemplateData {
    private final String id;
    private final String customId;
    private final String status;
    private final String category;
    private final List<String> possibleCategories;
    private final Date createdAt;
    private final Date lastModified;
    private final List<String> tags;
    private final List<String> suggestedTags;
    private final String baseAccess;
    private final List<String> availableAccess;
    private final List<String> userGroups;
    private final List<String> possibleUserGroups;

    public TemplateData(String id, String customId, String status, Date createdAt, Date lastModified) {
        this.id = id;
        this.customId = customId;
        this.category = "Project";
        this.possibleCategories = getDefaultPossibleCategories();
        this.status = status;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
        this.tags = new ArrayList<>();
        this.suggestedTags = getDefaultSuggestedTags();
        this.baseAccess = "Only members of the team";
        this.availableAccess = getDefaultAvailableAccess();
        this.userGroups = new ArrayList<>();
        this.possibleUserGroups = getDefaultPossibleUserGroups();
    }

    private List<String> getDefaultPossibleCategories() {
        return List.of(
                "Not set",
                "TRR270 Cluster Meetings",
                "Sub-Project",
                "Publication",
                "Equipment",
                "Technique",
                "Material",
                "Sample"
        );
    }

    private List<String> getDefaultSuggestedTags() {
        return List.of(
                "Magnetism first",
                "(Crn)2GaC",
                "(La,RE)(Fe,Si)13",
                "1:13",
                "1:5",
                "1.4301",
                "1.4301, rotary swaging",
                "119Sn",
                "161Dy",
                "2:14:1",
                "2:17",
                "2D-magnetism",
                "3DPrint",
                "4Q BSE",
                "57Fe",
                "6-13-1",
                "A01",
                "A02",
                "A03",
                "A04",
                "A05",
                "A06",
                "A07",
                "A08",
                "A09",
                "A10",
                "A11",
                "A12",
                "AC",
                "AC susceptibility",
                "AceFEM",
                "AceGen",
                "additive manufacturing",
                "adiabatic conditions",
                "Al",
                "AL203",
                "all-d",
                "all-d Heuslers",
                "analytic",
                "anisotropy",
                "Annealed",
                "annealing",
                "antiferromagnetism",
                "antiperovskite",
                "api-test-tag",
                "APS",
                "APT",
                "APV",
                "arc melting",
                "archmiedes",
                "ARL",
                "Artemis",
                "As",
                "Atom probe tomography",
                "Au",
                "austenite",
                "B",
                "B01",
                "B02",
                "B03",
                "B04",
                "B05",
                "B06",
                "B07",
                "B08",
                "B10",
                "B11",
                "B12",
                "ball milling",
                "barocaloric",
                "Be-Cu pressure cell",
                "beam splitter",
                "BESSY II",
                "BM30",
                "broadening",
                "C",
                "C02",
                "C03",
                "C05",
                "calibration",
                "cantor",
                "carbide",
                "Carbon films",
                "carbonitride",
                "CCA",
                "Ce",
                "Ce L2",
                "Ce L3",
                "Ce-Fe-B",
                "Ce(CoCu)5",
                "Ce2Fe14B",
                "CeCo5",
                "CeCu5",
                "CeFe11Ti",
                "CeFe11TiN",
                "CeFe2",
                "cellular structure",
                "CEMS",
                "ceramic",
                "Cluster 04"
        );
    }

    private List<String> getDefaultAvailableAccess() {
        return List.of(
                "Everyone including anonymous users",
                "Everyone with an account",
                "Only members of the team",
                "Only owner and admins",
                "Only owner"
        );
    }

    private List<String> getDefaultPossibleUserGroups() {
        return List.of(
                "Not set",
                "TRR270 Cluster Meetings",
                "Sub-Project",
                "Publication",
                "Equipment",
                "Technique",
                "Material",
                "Sample"
        );
    }

    public String getId() { return id; }
    public String getCustomId() { return customId; }
    public String getCategory() { return category; }
    public List<String> getPossibleCategroies() { return possibleCategories; }
    public String getStatus() { return status; }
    public Date getCreatedAt() { return createdAt; }
    public Date getLastModified() { return lastModified; }
    public List<String> getTags() { return tags; }
    public List<String> getSuggestedTags() { return suggestedTags; }
    public String getBaseAccess() { return baseAccess; }
    public List<String> getAvailableAccess() { return availableAccess; }
    public List<String> getUserGroups() { return userGroups; }
    public List<String> getPossibleUserGroups() { return possibleUserGroups; }
}
