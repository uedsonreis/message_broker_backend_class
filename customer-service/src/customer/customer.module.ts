import { Module } from '@nestjs/common';
import { ClientsModule, Transport } from '@nestjs/microservices';

import { CustomerService } from './customer.service';
import { CustomerController } from './customer.controller';
import { CustomerMessageBroker } from './customer.message.broker';

@Module({
    imports: [
        ClientsModule.register([
            {
                name: 'CUSTOMER_SERVICE',
                transport: Transport.RMQ,
                options: {
                    urls: ['amqp://192.168.0.4:5672'],
                    queue: 'customer_queue',
                    queueOptions: { durable: false },
                },
            },
        ])
    ],
    controllers: [ CustomerController ],
    providers: [ CustomerMessageBroker, CustomerService ],
})
export class CustomerModule {}