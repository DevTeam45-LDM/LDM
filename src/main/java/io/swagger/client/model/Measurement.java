package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

public class Measurement {

    @JsonProperty("measureinfo")
    private MeasureInfo measureInfo;

    @JsonProperty("dimension")
    private Dimension dimension;

    @JsonProperty("results")
    private Results results;

    @JsonProperty("validsubset")
    private ValidSubset validSubset;

    @JsonProperty("numConditioning")
    private NumConditioning numConditioning;

    @JsonProperty("datablock")
    private List<Data> dataBlock;

    @JsonProperty("_ID")
    private String id;

    @JsonProperty("_reference")
    private String reference;

    @JsonProperty("_coil")
    private Integer coil;

    @JsonProperty("_probID")
    private String probID;

    @JsonProperty("_sample")
    private String sample;

    @JsonProperty("_material")
    private String material;

    @JsonProperty("_temperature")
    private Double temperature;

    @JsonProperty("_coil_temperature")
    private Double coilTemperature;

    @JsonProperty("_Q_TseqBG")
    private Integer qTseqBG;

    @JsonProperty("_Q_TseqMS")
    private Integer qTseqMS;

    // Getters and setters

    /**
     * Get measureInfo
     *
     * @return measureInfo
     */
    public MeasureInfo getMeasureInfo() {
        return measureInfo;
    }

    /**
     * Set measureInfo
     *
     * @param measureInfo
     */
    public void setMeasureInfo(MeasureInfo measureInfo) {
        this.measureInfo = measureInfo;
    }

    /**
     * Get dimension
     *
     * @return dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * Set dimension
     *
     * @param dimension
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * Get results
     *
     * @return results
     */
    public Results getResults() {
        return results;
    }

    /**
     * Set results
     *
     * @param results
     */
    public void setResults(Results results) {
        this.results = results;
    }

    /**
     * Get validSubset
     *
     * @return validSubset
     */
    public ValidSubset getValidSubset() {
        return validSubset;
    }

    /**
     * Set validSubset
     *
     * @param validSubset
     */
    public void setValidSubset(ValidSubset validSubset) {
        this.validSubset = validSubset;
    }

    /**
     * Get numConditioning
     *
     * @return numConditioning
     */
    public NumConditioning getNumConditioning() {
        return numConditioning;
    }

    /**
     * Set numConditioning
     *
     * @param numConditioning
     */
    public void setNumConditioning(NumConditioning numConditioning) {
        this.numConditioning = numConditioning;
    }

    /**
     * Get dataBlock
     *
     * @return dataBlock
     */
    public List<Data> getDataBlock() {
        return dataBlock;
    }

    /**
     * Set dataBlock
     *
     * @param dataBlock
     */
    public void setDataBlock(List<Data> dataBlock) {
        this.dataBlock = dataBlock;
    }

    /**
     * Get id
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get reference
     *
     * @return reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Set reference
     *
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Get coil
     *
     * @return coil
     */
    public Integer getCoil() {
        return coil;
    }

    /**
     * Set coil
     *
     * @param coil
     */
    public void setCoil(Integer coil) {
        this.coil = coil;
    }

    /**
     * Get probID
     *
     * @return probID
     */
    public String getProbID() {
        return probID;
    }

    /**
     * Set probID
     *
     * @param probID
     */
    public void setProbID(String probID) {
        this.probID = probID;
    }

    /**
     * Get sample
     *
     * @return sample
     */
    public String getSample() {
        return sample;
    }

    /**
     * Set sample
     *
     * @param sample
     */
    public void setSample(String sample) {
        this.sample = sample;
    }

    /**
     * Get material
     *
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Set material
     *
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Get temperature
     *
     * @return temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * Set temperature
     *
     * @param temperature
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    /**
     * Get coilTemperature
     *
     * @return coilTemperature
     */
    public Double getCoilTemperature() {
        return coilTemperature;
    }

    /**
     * Set coilTemperature
     *
     * @param coilTemperature
     */
    public void setCoilTemperature(Double coilTemperature) {
        this.coilTemperature = coilTemperature;
    }

    /**
     * Get qTseqBG
     *
     * @return qTseqBG
     */
    public Integer getQTseqBG() {
        return qTseqBG;
    }

    /**
     * Set qTseqBG
     *
     * @param qTseqBG
     */
    public void setQTseqBG(Integer qTseqBG) {
        this.qTseqBG = qTseqBG;
    }

    /**
     * Get qTseqMS
     *
     * @return qTseqMS
     */
    public Integer getQTseqMS() {
        return qTseqMS;
    }

    /**
     * Set qTseqMS
     *
     * @param qTseqMS
     */
    public void setQTseqMS(Integer qTseqMS) {
        this.qTseqMS = qTseqMS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Objects.equals(measureInfo, that.measureInfo) &&
                Objects.equals(dimension, that.dimension) &&
                Objects.equals(results, that.results) &&
                Objects.equals(validSubset, that.validSubset) &&
                Objects.equals(numConditioning, that.numConditioning) &&
                Objects.equals(dataBlock, that.dataBlock) &&
                Objects.equals(id, that.id) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(coil, that.coil) &&
                Objects.equals(probID, that.probID) &&
                Objects.equals(sample, that.sample) &&
                Objects.equals(material, that.material) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(coilTemperature, that.coilTemperature) &&
                Objects.equals(qTseqBG, that.qTseqBG) &&
                Objects.equals(qTseqMS, that.qTseqMS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measureInfo, dimension, results, validSubset, numConditioning, dataBlock, id, reference, coil, probID, sample, material, temperature, coilTemperature, qTseqBG, qTseqMS);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Measurement {\n");
        sb.append("    measureInfo: ").append(toIndentedString(measureInfo)).append("\n");
        sb.append("    dimension: ").append(toIndentedString(dimension)).append("\n");
        sb.append("    results: ").append(toIndentedString(results)).append("\n");
        sb.append("    validSubset: ").append(toIndentedString(validSubset)).append("\n");
        sb.append("    numConditioning: ").append(toIndentedString(numConditioning)).append("\n");
        sb.append("    dataBlock: ").append(toIndentedString(dataBlock)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    coil: ").append(toIndentedString(coil)).append("\n");
        sb.append("    probID: ").append(toIndentedString(probID)).append("\n");
        sb.append("    sample: ").append(toIndentedString(sample)).append("\n");
        sb.append("    material: ").append(toIndentedString(material)).append("\n");
        sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
        sb.append("    coilTemperature: ").append(toIndentedString(coilTemperature)).append("\n");
        sb.append("    qTseqBG: ").append(toIndentedString(qTseqBG)).append("\n");
        sb.append("    qTseqMS: ").append(toIndentedString(qTseqMS)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
