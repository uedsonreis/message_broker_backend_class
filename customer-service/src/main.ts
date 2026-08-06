import { NestFactory } from '@nestjs/core';
// import { CustomTransportStrategy, MicroserviceOptions, Transport } from '@nestjs/microservices';

import { AppModule } from './app.module';

async function bootstrap() {
    const app = await NestFactory.create(AppModule);

    // app.connectMicroservice<MicroserviceOptions>({
    //     transport: Transport.RMQ,
    //     options: {
    //         urls: ['amqp://localhost:5672'],
    //         queue: 'customer_queue',
    //         queueOptions: { durable: true },
    //     },
    // });
    // await app.startAllMicroservices();

    await app.listen(3000);
}
bootstrap();