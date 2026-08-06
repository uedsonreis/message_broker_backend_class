import { Inject, Injectable } from "@nestjs/common";
import { ClientProxy } from "@nestjs/microservices";

import { Customer } from "./model";

@Injectable()
export class CustomerMessageBroker {

    constructor(
        @Inject('CUSTOMER_SERVICE') private readonly client: ClientProxy
    ) {}

    public emitSave(customer: Customer) {
        this.client.emit('customer.save', customer).subscribe(response => {
            console.log('Customer updated sent - response: ', response);
        });
    }

    public emitRemove(customer: Customer) {
        this.client.emit('customer.delete', customer).subscribe(response => {
            console.log('Customer delete sent - response: ', response);
        });
    }

}