#import "NivelBateria.h"
#import <Cordova/CDV.h>

@implementation NivelBateria

- (void)obtenerNivelBateria:(CDVInvokedUrlCommand*)command
{
    [[UIDevice currentDevice] setBatteryMonitoringEnabled:YES];
    double nivelBateria = (float) [[UIDevice currentDevice] batteryLevel];

    NSDictionary *resultado = [ [NSDictionary alloc]
        initWithObjectsAndKeys :
        [NSString stringWithFormat:@"%f", nivelBateria], @"nivelBateria",
        @"true", @"success",
        nil
    ];

    CDVPluginResult *resultadoPlugin = [ CDVPluginResult
        resultWithStatus : CDVCommandStatus_OK
        messageAsDictionary : resultado
    ];

    [self.commandDelegate sendPluginResult:resultadoPlugin callbackId:command.callbackId];
}

@end