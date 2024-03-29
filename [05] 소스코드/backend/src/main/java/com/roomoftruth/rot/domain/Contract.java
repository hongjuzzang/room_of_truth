package com.roomoftruth.rot.domain;

import com.roomoftruth.rot.dto.contracts.ContractSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "contract")
public class Contract implements Comparable<Contract>{

    @Id
    @Column(name = "contract_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @Column(name = "around_around_id", nullable = false)
    private Long aroundId;
    private String exclusive;
    private String floor;
    private String ho;
    private String kind;
    private String detail;
    private Long cost;
    private String monthly;

    @Column(nullable = false)
    private String license;
    private String image;

    @Column(name = "contract_date")
    private LocalDate contractDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_expired")
    private String isExpired;

    public void setImage(String image) {
        this.image = image;
    }

    @Builder
    public Contract(long aroundId, ContractSaveRequestDto contractSaveRequestDto) {
        this.aroundId = aroundId;
        this.exclusive = contractSaveRequestDto.getExclusive();
        this.floor = contractSaveRequestDto.getFloor();
        this.ho = contractSaveRequestDto.getHo();
        this.kind = contractSaveRequestDto.getKind();
        this.detail = contractSaveRequestDto.getDetail();
        this.cost = contractSaveRequestDto.getCost();
        this.monthly = contractSaveRequestDto.getMonthly();
        this.license = contractSaveRequestDto.getLicense();
        this.image = contractSaveRequestDto.getImage();
        this.contractDate = contractSaveRequestDto.getContractDate();
        this.createdAt = LocalDate.now();
        this.isExpired = "N";
    }

    @Override
    public int compareTo(Contract o) {
        return o.contractDate.compareTo(this.contractDate);
    }
}