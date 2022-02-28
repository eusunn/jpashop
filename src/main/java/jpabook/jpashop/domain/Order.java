package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY) // ManyToOne, OneToOne 은 default 값이 eager 그래서 FetchType.Lazy로 설정해줘야한다.
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // OneToMany은 default 값이 LAZY
    private List<OrderItem> orderItems = new ArrayList<>();

    //원래 이렇게 해야했던걸
    //persist(orderItemA)
    //persist(orderItemB)
    //persist(orderItemC)
    //persist(order)

    //persist(order)


    //cascade = CascadeType.ALL 설정해주면
    //persist(order)

    //persist(order)
    //이렇게 해도됌됌

    @OneToOne (fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    //order_date
    private LocalDateTime orderDate; // 주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태 [ORDER, CANCEL]

    //== 연관관계 메서드 == 양방향일 때 사용하면 좋음//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
