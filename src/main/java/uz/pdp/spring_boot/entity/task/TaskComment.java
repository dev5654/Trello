package uz.pdp.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author : Oyatjon  -> @data :2/23/2022 22:35
 */


@Getter
@Setter
@Entity
@Table(name = "task_comment", schema = "task")
public class TaskComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "message")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;




    @Convert(disableConversion = true)
    @Column(name = "created_at")
    private Instant createdat;

    @Column(name = "created_by", nullable = false)
    private Long createby;

    @Convert(disableConversion = true)
    @Column(name = "updated_at")
    private Instant updatedat;

    @Column(name = "updated_by")
    private Long updateby;
}
