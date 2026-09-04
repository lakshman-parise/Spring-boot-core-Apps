package com.nit.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	@Column(name="DOC_ID")
	@Id
	//@SequenceGenerator(name="gen1",sequenceName="DOCID_SEQ",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.AUTO)
    private Integer docId;
	@Column(name="DOC_NAME",length=25)
	private String docName;
	@Column(name="SPECIALIZATION",length=20)
	private String specialization;
	//@Transient
    @Column(name="INCOME")
    @NonNull
    private Double income; 
	
}
