package com.wordpress.marekdec.pizza.service;

import static com.googlecode.komarro.Komarro.given;
import static com.googlecode.komarro.Komarro.instanceForTesting;
import static com.googlecode.komarro.MockitoMockDescriptionCreator.annotatedMocks;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.wordpress.marekdec.pizza.domain.Address;
import com.wordpress.marekdec.pizza.domain.Order;
import com.wordpress.marekdec.pizza.domain.Pizza;
import com.wordpress.marekdec.pizza.repository.OrderRepository;

public class OrderServiceTest {

	@Mock
	private OrderRepository orderRepository;

	private OrderService orderService;

	@Before
	public void init() {
		initMocks(this);

		orderService = instanceForTesting(OrderService.class,
				annotatedMocks(this));
	}

	@Test
	public void testPlaceOrderSavesOrder() {
		// given
		given(Pizza.class).isRequested().thenReturn(new Pizza("Margharita"));
		given(Order.class).isRequested().thenReturn(newOrderWithId(17L));

		// when
		long orderId = orderService.placeOrder("margharita", new Address(
				"Embarcadero Rd 123", "Isla Vista", "93117"));

		// then
		verify(orderRepository).save(any(Order.class));
		assertThat(orderId).isEqualTo(17L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlaceOrderForAPizzaWithAnUnknownName() {
		// given
		given(Pizza.class).isRequested().thenReturn(null);

		// when
		orderService.placeOrder("hawaiian", new Address("Embarcadero Rd 123",
				"Isla Vista", "93117"));

		// then expect an exception
	}

	private Order newOrderWithId(long id) {
		Order order = new Order();
		order.setId(id);
		return order;
	}

}
