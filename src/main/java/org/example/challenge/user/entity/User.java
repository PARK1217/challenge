package org.example.challenge.user.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jdk.jfr.Description;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Description("회원정보")
@Table(name = "user_t")
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @Comment("회원아이디")
    private Long id;

    @Column(name = "nick", length = 20, nullable = false)
    @Comment("회원닉네임")
    private String nickName;

    @Column(name = "user_type", length = 1, nullable = false)
    @Comment("회원구분")
    private String userType;

    @Column(name = "email", length = 50, nullable = false)
    @Comment("이메일")
    private String email;

    @Column(name = "password", length = 50, nullable = false)
    @Comment("패스워드")
    private String password;

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
}
