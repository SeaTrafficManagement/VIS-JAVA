## Generate Java classes using JAXB from an XSD file
For S124.xsd file, you have to use a binding.xjb file to resolve problems related with repeated names in the imported schemas.
To generate Java classes, execute this command:

`xjc -b binding.xjb -d src -p stm.vis.model.area -XautoNameResolution S124.xsd`

For other XML schema files, no binding file is necessary. So, you can execute the following command:

`xjc -d src -p stm.vis.model.area <filename>.xsd`
