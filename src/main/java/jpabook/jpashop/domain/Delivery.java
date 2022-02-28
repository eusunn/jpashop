package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 타입을 넣을 때 디폴트 값이 Ordinary인데 레디면 1 comp 면 2가 들어간다 치면 다른 상태가 들어가게 되면 중간에 끼게 돼 XXX로 나오게 된다. 그래서 꼭 STRING으로 설정해줘야한다.!!!!!!
    private DeliveryStatus status; //READY, COMP
}
