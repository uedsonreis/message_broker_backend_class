import { Inject, Injectable } from "@nestjs/common";
import { ClientProxy, Ctx, MessagePattern, Payload, RmqContext } from "@nestjs/microservices";

import { Customer } from "./model";

@Injectable()
export class CustomerMessageBroker {

    constructor(
        @Inject('CUSTOMER_SERVICE') private readonly client: ClientProxy
    ) {}

    @MessagePattern('customer.update')
    getNotifications(@Payload() data: any, @Ctx() context: RmqContext) {
        console.log(`Pattern: ${context.getPattern()}`);
        console.log(data)
    }

    public update(customer: Customer) {
        console.log('Update Customer: ');
        this.client.emit('customer.update', customer).subscribe(response => {
            console.log('Customer updated sent:');
            console.log(response);
        });
    }

    public remove(customer: Customer) {
        this.client.emit('customer.delete', customer).subscribe(response => {
            console.log(response);
        });
    }

}