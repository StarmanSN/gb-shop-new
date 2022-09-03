package ru.gb.gbshopmay.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.gbapimay.common.enums.OrderStatus;
import ru.gb.gbshopmay.entity.common.InfoEntity;
import ru.gb.gbshopmay.entity.security.AccountUser;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "shop_order")
@EntityListeners(AuditingEntityListener.class)
public class Order extends InfoEntity {

    @Column(name = "recipient_firstname")
    private String recipientFirstname;

    @Column(name = "recipient_lastname")
    private String recipientLastname;

    @Column(name = "recipient_phone")
    private String recipientPhone;

    @Column(name = "recipient_mail")
    private String recipientMail;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "shop_address_id")
    private Address shopAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccountUser accountUser;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    @Builder
    public Order(Long id, int version, String createdBy, LocalDateTime createdDate, String lastModifiedBy,
                 LocalDateTime lastModifiedDate, String recipientFirstname, String recipientLastname, String recipientPhone,
                 String recipientMail, OrderStatus status, LocalDate deliveryDate, BigDecimal deliveryPrice,
                 Address deliveryAddress, Address shopAddress, AccountUser accountUser, List<OrderItem> orderItems) {
        super(id, version, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.recipientFirstname = recipientFirstname;
        this.recipientLastname = recipientLastname;
        this.recipientPhone = recipientPhone;
        this.recipientMail = recipientMail;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.deliveryPrice = deliveryPrice;
        this.deliveryAddress = deliveryAddress;
        this.shopAddress = shopAddress;
        this.accountUser = accountUser;
        this.orderItems = orderItems;
    }
}
