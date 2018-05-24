package org.eclipse.om2m.ipu.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.core.service.SclService;
import org.eclipse.om2m.ipu.service.IpuService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
    /** Logger */
    private static Log logger = LogFactory.getLog(Activator.class);
    /** SCL service tracker */
    private ServiceTracker<Object, Object> sclServiceTracker;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        logger.info("Register IpuService..");
        bundleContext.registerService(IpuService.class.getName(), new SampleController(), null);
        logger.info("IpuService is registered.");

        sclServiceTracker = new ServiceTracker<Object, Object>(bundleContext, SclService.class.getName(), null) {
            public void removedService(ServiceReference<Object> reference, Object service) {
                logger.info("SclService removed");
            }

            public Object addingService(ServiceReference<Object> reference) {
                logger.info("SclService discovered");
                SclService sclService = (SclService) this.context.getService(reference);
                final SampleMonitor ipuMonitor = new SampleMonitor(sclService);
                new Thread(){
                    public void run(){
                        try {
                            ipuMonitor.start();
                        } catch (Exception e) {
                            logger.error("IpuMonitor Sample error", e);
                        }
                    }
                }.start();
                return sclService;
            }
        };
        sclServiceTracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        logger.error("Stop IPU Phidgets monitor");
        try {
            SampleMonitor.stop();

        } catch (Exception e) {
            logger.error("Stop Phidgets error", e);
        }
    }

}
