package com.reader.data;

public class TeamData {
    public String Issue_key;
    public int issueId;
    public String parentId;
    public String summary;
    public String status;
    public String issueType;
    public String originalEstimate;
    public String priority;
    public String team;

    @Override
    public String toString() {
        return status;
    }

    public String getIssue_key() {
        return this.Issue_key;
    }

    public int getIssueId() {
        return this.issueId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getStatus() {
        return this.status;
    }

    public String getIssueType() {
        return this.issueType;
    }

    public String getOriginalEstimate() {
        return this.originalEstimate;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getTeam() {
        return this.team;
    }

    public void setIssue_key(String Issue_key) {
        this.Issue_key = Issue_key;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
