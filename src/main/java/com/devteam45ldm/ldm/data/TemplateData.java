package com.devteam45ldm.ldm.data;

import java.util.List;
import java.util.ArrayList;

public class TemplateData {
    private final String id;
    private final String customId;
    private final String status;
    private final String category;
    private final List<String> possibleCategories;
    private final String createdAt;
    private final String lastModified;
    private final List<String> tags;
    private final List<String> suggestedTags;
    private final String baseAccess;
    private final List<String> availableAccess;
    private final List<String> userGroups;
    private final List<String> possibleUserGroups;

    public TemplateData(String id, String customId, String status, String category, String createdAt, String lastModified, List<String> tags, String baseAccess, List<String> userGroups) {
        this.id = id;
        this.customId = customId;
        this.status = status;
        this.category = category;
        this.possibleCategories = getDefaultPossibleCategories();
        this.createdAt = createdAt;
        this.lastModified = lastModified;
        this.tags = tags;
        this.suggestedTags = getDefaultSuggestedTags();
        this.baseAccess = baseAccess;
        this.availableAccess = getDefaultAvailableAccess();
        this.userGroups = userGroups;
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
                "CRC/TRR 270 - A01",
                "CRC/TRR 270 - A01/A08 HPT of Ni-Mn-Heusler alloys",
                "CRC/TRR 270 - A02",
                "CRC/TRR 270 - A03",
                "CRC/TRR 270 - A03/B05",
                "Administration and Support - A04",
                "CRC/TRR 270 - A04",
                "CRC/TRR 270 - A06",
                "CRC/TRR 270 - A07/A08",
                "CRC/TRR 270 - A07/A09",
                "CRC/TRR 270 - A08",
                "CRC/TRR 270 - A10",
                "CRC/TRR 270 - A10/A11",
                "CRC/TRR 270 - A11",
                "CRC/TRR 270 - A12-try",
                "CRC/TRR 270 - B01",
                "CRC/TRR 270 - B01/B10",
                "CRC/TRR 270 - B03",
                "CRC/TRR 270 - B04",
                "CRC/TRR 270 - B05",
                "CRC/TRR 270 - B05/B06",
                "CRC/TRR 270 - B07",
                "CRC/TRR 270 - B08",
                "CRC/TRR 270 - B09",
                "CRC/TRR 270 - B10",
                "CRC/TRR 270 - B11",
                "CRC/TRR 270 - C02",
                "CRC/TRR 270 - C05",
                "CRC/TRR 270 - MGK",
                "Administration and Support - PIs",
                "Administration and Support - Researchers",
                "Administration and Support - Students",
                "CRC/TRR 270 - Z-INF",
                "CRC/TRR 270 - Z02"
        );
    }

    public String getId() { return id; }
    public String getCustomId() { return customId; }
    public String getCategory() { return category; }
    public List<String> getPossibleCategroies() { return possibleCategories; }
    public String getStatus() { return status; }
    public String getCreatedAt() { return createdAt; }
    public String getLastModified() { return lastModified; }
    public List<String> getTags() { return tags; }
    public List<String> getSuggestedTags() { return suggestedTags; }
    public String getBaseAccess() { return baseAccess; }
    public List<String> getAvailableAccess() { return availableAccess; }
    public List<String> getUserGroups() { return userGroups; }
    public List<String> getPossibleUserGroups() { return possibleUserGroups; }
}
