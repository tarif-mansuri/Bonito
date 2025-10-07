//$Id$
package start.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsItem {

    @JsonProperty("NEWSID")
    private String newsId;

    @JsonProperty("SCRIP_CD")
    private long scripCd;

    @JsonProperty("XML_NAME")
    private String xmlName;

    @JsonProperty("NEWSSUB")
    private String newsSub;

    @JsonProperty("DT_TM")
    private String dtTm;

    @JsonProperty("NEWS_DT")
    private String newsDt;

    @JsonProperty("CRITICALNEWS")
    private int criticalNews;

    @JsonProperty("ANNOUNCEMENT_TYPE")
    private String announcementType;

    @JsonProperty("QUARTER_ID")
    private String quarterId;

    @JsonProperty("FILESTATUS")
    private String fileStatus;

    @JsonProperty("ATTACHMENTNAME")
    private String attachmentName;

    @JsonProperty("MORE")
    private String more;

    @JsonProperty("HEADLINE")
    private String headline;

    @JsonProperty("CATEGORYNAME")
    private String categoryName;

    @JsonProperty("OLD")
    private int old;

    @JsonProperty("RN")
    private int rn;

    @JsonProperty("PDFFLAG")
    private int pdfFlag;

    @JsonProperty("NSURL")
    private String nsUrl;

    @JsonProperty("SLONGNAME")
    private String sLongName;

    @JsonProperty("AGENDA_ID")
    private int agendaId;

    @JsonProperty("TotalPageCnt")
    private int totalPageCnt;

    @JsonProperty("News_submission_dt")
    private String newsSubmissionDt;

    @JsonProperty("DissemDT")
    private String dissemDt;

    @JsonProperty("TimeDiff")
    private String timeDiff;

    @JsonProperty("Fld_Attachsize")
    private long fldAttachSize;

    @JsonProperty("SUBCATNAME")
    private String subCatName;

    @JsonProperty("AUDIO_VIDEO_FILE")
    private String audioVideoFile;

    // Default constructor
    public NewsItem() {}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public long getScripCd() {
		return scripCd;
	}

	public void setScripCd(long scripCd) {
		this.scripCd = scripCd;
	}

	public String getXmlName() {
		return xmlName;
	}

	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}

	public String getNewsSub() {
		return newsSub;
	}

	public void setNewsSub(String newsSub) {
		this.newsSub = newsSub;
	}

	public String getDtTm() {
		return dtTm;
	}

	public void setDtTm(String dtTm) {
		this.dtTm = dtTm;
	}

	public String getNewsDt() {
		return newsDt;
	}

	public void setNewsDt(String newsDt) {
		this.newsDt = newsDt;
	}

	public int getCriticalNews() {
		return criticalNews;
	}

	public void setCriticalNews(int criticalNews) {
		this.criticalNews = criticalNews;
	}

	public String getAnnouncementType() {
		return announcementType;
	}

	public void setAnnouncementType(String announcementType) {
		this.announcementType = announcementType;
	}

	public String getQuarterId() {
		return quarterId;
	}

	public void setQuarterId(String quarterId) {
		this.quarterId = quarterId;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public int getPdfFlag() {
		return pdfFlag;
	}

	public void setPdfFlag(int pdfFlag) {
		this.pdfFlag = pdfFlag;
	}

	public String getNsUrl() {
		return nsUrl;
	}

	public void setNsUrl(String nsUrl) {
		this.nsUrl = nsUrl;
	}

	public String getsLongName() {
		return sLongName;
	}

	public void setsLongName(String sLongName) {
		this.sLongName = sLongName;
	}

	public int getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(int agendaId) {
		this.agendaId = agendaId;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public String getNewsSubmissionDt() {
		return newsSubmissionDt;
	}

	public void setNewsSubmissionDt(String newsSubmissionDt) {
		this.newsSubmissionDt = newsSubmissionDt;
	}

	public String getDissemDt() {
		return dissemDt;
	}

	public void setDissemDt(String dissemDt) {
		this.dissemDt = dissemDt;
	}

	public String getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(String timeDiff) {
		this.timeDiff = timeDiff;
	}

	public long getFldAttachSize() {
		return fldAttachSize;
	}

	public void setFldAttachSize(long fldAttachSize) {
		this.fldAttachSize = fldAttachSize;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public String getAudioVideoFile() {
		return audioVideoFile;
	}

	public void setAudioVideoFile(String audioVideoFile) {
		this.audioVideoFile = audioVideoFile;
	}
    
    

}
