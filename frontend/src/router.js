
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManagementManager from "./components/listers/OrderOrderManagementCards"
import OrderOrderManagementDetail from "./components/listers/OrderOrderManagementDetail"

import DeliveryDeliveryManagementManager from "./components/listers/DeliveryDeliveryManagementCards"
import DeliveryDeliveryManagementDetail from "./components/listers/DeliveryDeliveryManagementDetail"

import ProductProductManagementManager from "./components/listers/ProductProductManagementCards"
import ProductProductManagementDetail from "./components/listers/ProductProductManagementDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orderManagements',
                name: 'OrderOrderManagementManager',
                component: OrderOrderManagementManager
            },
            {
                path: '/orders/orderManagements/:id',
                name: 'OrderOrderManagementDetail',
                component: OrderOrderManagementDetail
            },

            {
                path: '/deliveries/deliveryManagements',
                name: 'DeliveryDeliveryManagementManager',
                component: DeliveryDeliveryManagementManager
            },
            {
                path: '/deliveries/deliveryManagements/:id',
                name: 'DeliveryDeliveryManagementDetail',
                component: DeliveryDeliveryManagementDetail
            },

            {
                path: '/products/productManagements',
                name: 'ProductProductManagementManager',
                component: ProductProductManagementManager
            },
            {
                path: '/products/productManagements/:id',
                name: 'ProductProductManagementDetail',
                component: ProductProductManagementDetail
            },



    ]
})
