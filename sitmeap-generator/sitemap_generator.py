import gzip
import io
from datetime import datetime
from xml.dom import minidom
from xml.etree import ElementTree
from xml.etree.ElementTree import Element, SubElement


def prettify(elem):
    rough_string = ElementTree.tostring(elem, 'utf-8')
    reparsed = minidom.parseString(rough_string)
    return reparsed.toprettyxml(indent="  ")


def index():
    sitemap_index = Element('sitemapindex')

    for char in ['a', 'b', 'c', 'd', 'e']:
        sitemap = SubElement(sitemap_index, 'sitemap')
        loc = SubElement(sitemap, 'loc')
        loc.text = 'http://localhost:8080/sitemap/' + char + '.xml.gz'
        lastmod = SubElement(sitemap, 'lastmod')
        lastmod.text = str(datetime.now())

        urlset = Element('urlset')  # todo tags
        for second_char in ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i']:
            url = SubElement(urlset, 'url')
            url_loc = SubElement(url, 'loc')
            url_loc.text = "http://localhost:8080/test/" + char + second_char
            url_lastmod = SubElement(url, 'lastmod')
            url_lastmod.text = str(datetime.now())
            file_name = 'sitemap_' + char

        create_xml_gz(prettify(urlset), file_name + '.xml.gz')
        create_xml(prettify(urlset), file_name + '.xml')

    create_xml_gz(prettify(sitemap_index), 'sitemap.xml.gz')
    create_xml(prettify(sitemap_index), 'sitemap.xml')


def create_xml_gz(content, name):
    with gzip.open(name, 'a+') as gz_file:
        with io.TextIOWrapper(gz_file, encoding='UTF-8') as encode:
            encode.write(content)
        # gz_file.write(content.encode('UTF_8'))
        # encode.close()
    # gz_file.close()


def create_xml(content, name):
    with open(name, 'a+') as gz_file:
        gz_file.write(content)
    # gz_file.close()


index()
