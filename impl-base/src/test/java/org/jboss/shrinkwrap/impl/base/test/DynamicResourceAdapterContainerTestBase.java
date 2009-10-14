package org.jboss.shrinkwrap.impl.base.test;

import junit.framework.Assert;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Path;
import org.jboss.shrinkwrap.api.container.ResourceAdapterContainer;
import org.jboss.shrinkwrap.impl.base.path.BasicPath;
import org.junit.Test;

public abstract class DynamicResourceAdapterContainerTestBase<T extends Archive<T>> extends DynamicContainerTestBase<T>
{

   protected abstract Path getResourceAdapterPath();
   protected abstract ResourceAdapterContainer<T> getResourceAdapterContainer();
   
   @Test
   @ArchiveType(ResourceAdapterContainer.class)
   public void testSetResourceAdapterXMLResource() throws Exception {
      getResourceAdapterContainer().setResourceAdapterXML(NAME_TEST_PROPERTIES);
      
      Path testPath = new BasicPath(getResourceAdapterPath(), "ra.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }
   
   @Test
   @ArchiveType(ResourceAdapterContainer.class)
   public void testSetResourceAdapterXMLFile() throws Exception {
      getResourceAdapterContainer().setResourceAdapterXML(getFileForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getResourceAdapterPath(), "ra.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(ResourceAdapterContainer.class)
   public void testSetResourceAdapterXMLURL() throws Exception {
      getResourceAdapterContainer().setResourceAdapterXML(getURLForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getResourceAdapterPath(), "ra.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }

   @Test
   @ArchiveType(ResourceAdapterContainer.class)
   public void testSetResourceAdapterXMLAsset() throws Exception {
      getResourceAdapterContainer().setResourceAdapterXML(getAssetForClassResource(NAME_TEST_PROPERTIES));
      
      Path testPath = new BasicPath(getResourceAdapterPath(), "ra.xml");
      Assert.assertTrue(
            "Archive should contain " + testPath,
            getArchive().contains(testPath));
   }
}