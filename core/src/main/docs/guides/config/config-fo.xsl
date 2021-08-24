<?xml version="1.0"?>

<!--
 Related Values Processing Framework.

 $Id: config-fo.xsl 1491 2011-05-10 12:33:42Z sfb $
 -->

<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        version='1.0'>

    <xsl:import href="http://docbook.sourceforge.net/release/xsl/current/fo/docbook.xsl"/>

    <xsl:param name="draft.mode">no</xsl:param>
    <xsl:param name="fop1.extensions">1</xsl:param>

    <xsl:param name="toc.section.depth">3</xsl:param>
    <xsl:param name="make.year.ranges">1</xsl:param>
    <xsl:param name="make.single.year.ranges">1</xsl:param>

    <xsl:param name="symbol.font.family"></xsl:param>

    <xsl:template name="root.messages"/>

    <xsl:attribute-set name="section.level1.properties">
        <xsl:attribute name="break-before">page</xsl:attribute>
    </xsl:attribute-set>

</xsl:stylesheet>

<!-- End. -->
