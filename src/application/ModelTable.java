package application;

public class ModelTable {

	String id,emri,eprindit,mbiemri,fakulteti,qyteti,nrpersonal,adresa,tel,email,gjinia;
	
	public ModelTable(String id,String emri,String eprindit,String mbiemri,String fakulteti,String qyteti,String nrpersonal,String adresa,String tel,String email,String gjinia) {
		
		this.id=id;
		this.emri=emri;
		this.eprindit=eprindit;
		this.mbiemri=mbiemri;
		this.fakulteti=fakulteti;
		this.qyteti=qyteti;
		this.nrpersonal=nrpersonal;
		this.adresa=adresa;
		this.tel=tel;
		this.email=email;
		this.gjinia=gjinia;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getEmri() {
		return emri;
	}
	public void seEmri(String emri) {
		this.emri=emri;
	}
	public String getEprindit() {
		return eprindit;
	}
	public void setEprindit(String eprindit) {
		this.eprindit=eprindit;
	}
	public String getMbiemri() {
		return mbiemri;
	}
	public void setMbiemri(String mbiemri) {
		this.mbiemri=mbiemri;
	}
	public String getFakulteti() {
		return fakulteti;
	}
	public void setFakulteti(String fakulteti) {
		this.fakulteti=fakulteti;
	}
	public String getQyteti() {
		return qyteti;
	}
	public void setQyteti(String qyteti) {
		this.qyteti=qyteti;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public String getGjinia() {
		return gjinia;
	}
	public void setGjinia(String gjinia) {
		this.gjinia=gjinia;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa=adresa;
	}
	public String getNrpersonal() {
		return nrpersonal;
	}
	public void setNrpersonal(String nrpersonal) {
		this.nrpersonal=nrpersonal;
	}
}
 
