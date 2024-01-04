package org.example.challenge.challenge.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jdk.jfr.Description;
import lombok.*;
import org.example.challenge.user.entity.User;
import org.hibernate.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Description("챌린지정보")
@Table(name = "challenge_t")
@DynamicUpdate
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id", nullable = false)
    @Comment("챌린지아이디")
    private Long id;

    @Column(name = "chall_name", length = 20, nullable = false)
    @Comment("챌린지명")
    private String challName;

    @Column(name = "ava_people", length = 3, nullable = false)
    @Comment("정원수")
    private int avaPeople;

    @Column(name = "now_people", length = 3)
    @Comment("현재인원")
    private int nowPeople;

    @Lob
    @Column(name = "introduction")
    @ColumnTransformer(
            read = "cast(introduction as text)",
            write = "?::text"
    )
    @Comment("챌린지소개")
    private String introduction;

    @Column(name = "start_date", length = 10, nullable = false)
    @Comment("시작날짜")
    private LocalDate startDate;

    @Column(name = "end_date", length = 10, nullable = false)
    @Comment("종료날짜")
    private LocalDate endDate;

    @ColumnDefault("'N'")
    @Comment("삭제여부")
    private String delYn;

    @CreationTimestamp
    @Comment("등록일시")
    @Column(nullable = false, length = 20, updatable = false)
    private LocalDateTime regDttm;

    @UpdateTimestamp
    @Comment("수정일시")
    @Column(length = 20)
    private LocalDateTime modDttm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Comment("챌린지개설자")
    private User user;



}
